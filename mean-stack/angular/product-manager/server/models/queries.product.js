const Product = require("./Product");

module.exports = {
  getAllProducts(callback) {
    Product.find({}).then(tasks => {
      callback(null, tasks)
    })
    .catch(err => {
      callback(null);
    })
  },

  createProduct(postData, callback) {
    let price = postData.price || 0
    let newProduct = new Product({
      title: postData.title,
      price: price,
      img: postData.img
    });
    newProduct.save().then(product => {
      callback(null, product);
    })
    .catch(err => callback(err));
  },

  removeProduct(id, callback) {
    Product.findByIdAndDelete(id).then(() => {
      callback(null);
    })
    .catch(err => callback(err))
  },

  getProduct(id, callback) {
    Product.findById(id).then(product => {
      callback(null, product);
    })
    .catch(err => callback(err));
  },

  updateProduct(id, postData, callback) {
    let price = postData.price || 0
    let updateProduct = {
      title: postData.title,
      price: price,
      img: postData.img
    };
    Product.findByIdAndUpdate(id, {$set: updateProduct}, {runValidators: true}).then(product => {
      callback(null, product);
    })
    .catch(err => callback(err));
  }
}
