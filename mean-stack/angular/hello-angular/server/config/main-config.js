const session     = require("express-session");
      bodyParser  = require("body-parser");
      path        = require("path");

module.exports = {
  init(app, express) {
    app.use(express.static(path.join(__dirname, "../..", "public/dist/public")));
    app.use(bodyParser.json());
    app.use(session({
      secret: "kitty",
      resave: false,
      saveUninitialized: true,
      cookie: {maxAge: 60000}
    }));
  }
}