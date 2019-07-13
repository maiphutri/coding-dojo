const session     = require("express-session");
      bodyParser  = require("body-parser");
      path        = require("path");
      fileUpload  = require("express-fileupload");

module.exports = {
  init(app, express) {
    app.set("views", path.join(__dirname, "./views"));
    app.set("view engine", "ejs");
    app.use(bodyParser.urlencoded({extended: true}));
    app.use(express.static(path.join(__dirname, "./static")));
    app.use(session({
      secret: "kitty",
      resave: false,
      saveUninitialized: true,
      cookie: {maxAge: 60000}
    }));
    app.use(fileUpload());
  }
}