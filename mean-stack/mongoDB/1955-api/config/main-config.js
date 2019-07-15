const session     = require("express-session");
      bodyParser  = require("body-parser");

module.exports = {
  init(app, express) {
    app.use(bodyParser.json());
    app.use(session({
      secret: "kitty",
      resave: false,
      saveUninitialized: true,
      cookie: {maxAge: 60000}
    }));
  }
}