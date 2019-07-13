const express   = require("express");
      app       = express();
      appConfig = require("./main-config");
      Comment   = require("./models").Comment;
      Message   = require("./models").Message;

appConfig.init(app, express);

// HOME PAGE
app.get("/", (req, res) => {
  Message.find({}).then(messages => {
    res.render("index", {allMessages: messages})
  })
  .catch(err => console.log(err));
})

app.post("/message", (req, res) => {
  let msg = new Message(req.body);
  msg.save().then(() => {
    res.redirect("/");
  })
  .catch(err => {
    for (let key in err.errors) {
      req.flash("message", err.errors[key].message);
    }
    res.redirect("/");
  })
});

app.post("/message/:id", (req, res) => {
  let comment = new Comment(req.body);
  comment.save().then(comment => {
    Message.findByIdAndUpdate(req.params.id, {$push: {comments: comment}})
      .then(message => {
        res.redirect("/");
      })
      .catch(err => console.log(err))
  })
  .catch(err => {
    for (let key in err.errors) {
      req.flash("comment", err.errors[key].message);
    }
    res.redirect("/");
  });
})


app.get("*", (req, res) => {
  res.send("404 Page Not Found!");
})

module.exports = app;