module.exports = {
  init(app) {
    const productRoutes = require("../routes/products");
    
    app.use(productRoutes);
  }
}