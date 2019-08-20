module.exports = {
  init(app) {
    const authorRoutes = require("../routes/authors")
    app.use(authorRoutes);
  }
}