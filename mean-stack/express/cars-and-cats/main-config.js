module.exports = {
  init(app, express) {
    app.set("views", __dirname + "/views");
    app.set("view engine", "ejs");
    app.use(express.static(__dirname + "/static"))
  }
}