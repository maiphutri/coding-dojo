const express   = require("express");
      app       = express();
      appConfig = require("./main-config");
      Mongoose  = require("./models");
      fs        = require("fs");


appConfig.init(app, express);

// HOME PAGE
app.get("/", (req, res) => {
  Mongoose.find({}).then((mons) => {
    res.render("mongoose/index", {mons}); 
  })
  .catch(err => console.log(err));
})

// CREATE FORM
app.get("/mongooses/new", (req, res) => {
  res.render("mongoose/new");
})

// CREATE
app.post("/mongooses", (req, res) => {
  if (!req.files) {
    return res.status(400).send('No files were uploaded.');
  }

  let img = req.files.img;
  let uploadPath = __dirname + "/static/img/" + img.name;
  img.mv(uploadPath, err => {
    if (err) {
      return res.status(500).send(err);
    }
    let newMon = new Mongoose({
      name: req.body.name, 
      characteristic: req.body.characteristic,
      favFoods: req.body.favFoods.split(/[ ,]+/),
      img: img.name
    })
    newMon
      .save()
      .then(() => {
        res.redirect(`/mongooses/${newMon.id}`);
      })
      .catch(err => console.log(err))
  })
})

// SHOW 
app.get("/mongooses/:id", (req, res) => {
  Mongoose.findById(req.params.id).then((mon) => {
    res.render("mongoose/show", {mon});
  })
  .catch(err => console.log(err));
})

// EDIT
app.get("/mongooses/edit/:id", (req, res) => {
  Mongoose.findById(req.params.id).then((mon) => {
    res.render("mongoose/edit", {mon});
  })
  .catch(err => console.log(err));
})

// UPDATE
app.post("/mongooses/:id", (req, res) => {
  if (!req.files) {
    Mongoose.findByIdAndUpdate(req.params.id, {
      name: req.body.name,
      characteristic: req.body.characteristic,
      favFoods: req.body.favFoods,
    })
    .then((mon) => {
      res.redirect(`/mongooses/${mon.id}`)
    })
    .catch(err => console.log(err));
  }
  else {
    // REMOVE OLD IMAGE
    Mongoose.findById(req.params.id).then((mon) => {
      if (mon.img) { 
        let removePath = __dirname + "/static/img/" + mon.img;
        fs.unlink(removePath, err => console.log(err))
      }

      // UPDATE MONGOOSE
      let img = req.files.img;
      let uploadPath = __dirname + "/static/img/" + img.name;
      img.mv(uploadPath, err => {
        if (err) {
          return res.status(500).send(err);
        }
        Mongoose.findByIdAndUpdate(req.params.id, {
          name: req.body.name,
          characteristic: req.body.characteristic,
          favFoods: req.body.favFoods,
          img: img.name
        })
        .then((mon) => {
          res.redirect(`/mongooses/${mon.id}`)
        })
        .catch(err => console.log(err));
      })
    })
    .catch(err => console.log(err))  
  }
})

app.post("/mongooses/destroy/:id", (req, res) => {
  Mongoose.findById(req.params.id).then((mon) => {
    mon.remove().then(() => {
      res.redirect("/")
    })
    .catch(err => console.log(err));
  })
  .catch(err => console.log(err));
})

app.get("*", (req, res) => {
  res.send("404 Page Not Found!");
})

module.exports = app;