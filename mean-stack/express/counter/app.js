const express   = require("express");
      app       = express();
      appConfig = require("./main-config");

appConfig.init(app, express);

app.get("/", (req, res) => {
  if (!req.session.counter) {
    req.session.counter = 1;
  } else {
    req.session.counter++;
  }
  res.locals.counter = req.session.counter;
  res.render("index");
})

app.post("/add2", (req, res) => {
  req.session.counter++;
  res.redirect("/");
})

app.post("/reset", (req, res) => {
  req.session.counter = 0;
  res.redirect("/");
})

app.get("*", (req, res) => {
  res.send("404 Page Not Found!");
})

module.exports = app;