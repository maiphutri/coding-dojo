const express   = require("express");
      app       = express();
      appConfig = require("./main-config");

let result = {};

appConfig.init(app, express);

app.get("/", (req, res) => {
  if (!req.session.random) {
    req.session.random = Math.floor(Math.random() * 100) + 1;
    req.session.attempts = 0;
  }
  res.locals.attempts = req.session.attempts;
  res.locals.random = req.session.random;
  res.render("index", {result});
})

app.post("/guess", (req, res) => {
  if (req.body.guess > req.session.random) {
    result.answer = "Too high!";
    result.color = "red";
  }
  if (req.body.guess < req.session.random) {
    result.answer = "Too low!"
    result.color = "red";
  }
  if (req.body.guess == req.session.random) {
    result.answer = "Correct!"
    result.color = "green";
  }
  req.session.attempts++;
  res.redirect("/");
})

app.get("/reset", (req, res) => {
  delete req.session.random;
  delete result.answer;
  req.session.attempts = 0;
  res.redirect("/")
})

app.get("*", (req, res) => {
  res.send("404 Page Not Found!");
})

module.exports = app;