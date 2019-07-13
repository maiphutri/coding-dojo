const express   = require("express");
      app       = express();
      appConfig = require("./main-config");
      User      = require("./models");

appConfig.init(app, express);

// HOME PAGE
app.get("/", (req, res) => {
  res.render("index");
})

app.post("/registration", (req, res) => {
  let newUser = new User(req.body)
  newUser.save().then(user => {
    res.redirect("/")
  })
  .catch(err => {
    for (let key in err.errors) {
      req.flash("registration", err.errors[key].message);
    }
    res.redirect("/")
  })
})


app.get("*", (req, res) => {
  res.send("404 Page Not Found!");
})

module.exports = app;