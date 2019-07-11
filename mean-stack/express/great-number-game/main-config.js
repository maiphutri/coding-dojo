const session     = require("express-session");
      bodyParser = require("body-parser");

module.exports = {
  init(app, express) {
    app.set("views", __dirname + "/views");
    app.set("view engine", "ejs");
    app.use(bodyParser.urlencoded({extended: true}));
    app.use(express.static(__dirname + "/static"))
    app.use(session({
      secret: "kitty",
      resave: false,
      saveUninitialized: true,
      cookie: {maxAge: 60000}
    }))
  }
}