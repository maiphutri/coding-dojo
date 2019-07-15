const express    = require("express"),
      app        = express(),
      appConfig  = require("./config/main-config"),
      routeConfig = require("./config/route-config");

appConfig.init(app, express);
routeConfig.init(app);

app.get("*", (req, res) => {
  res.send("404 Page Not Found!");
})

module.exports = app;