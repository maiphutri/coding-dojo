const express     = require("express"),
      app         = express(),
      appConfig   = require("./config/main-config"),
      routeConfig = require("./config/route-config"),
      path        = require("path");

appConfig.init(app, express);
routeConfig.init(app);

app.all("*", (req, res) => {
  res.sendFile(path.join(__dirname, "..", "client/dist/client/index.html"));
})

module.exports = app;