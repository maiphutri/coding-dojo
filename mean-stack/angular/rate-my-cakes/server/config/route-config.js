module.exports = {
  init(app) {
    const cakeRoutes = require("../routes/cakes");
    
    app.use(cakeRoutes);
  }
}