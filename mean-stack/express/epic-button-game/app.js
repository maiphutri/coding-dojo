const express   = require("express");
      app       = express();
      appConfig = require("./main-config");


appConfig.init(app, express);

app.get("/", (req, res) => {
  res.render("index");
})

app.get("*", (req, res) => {
  res.send("404 Page Not Found!");
})

module.exports = app;