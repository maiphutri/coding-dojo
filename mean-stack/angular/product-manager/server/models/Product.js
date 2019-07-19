const mongoose    = require("mongoose"),
      shortid     = require("shortid");
      
mongoose.Promise = require("bluebird");
mongoose.connect("mongodb://localhost/product-manager", {useNewUrlParser: true})


const ProductSchema = new mongoose.Schema({
  _id: {
    type: String,
    default: shortid.generate
  },
  title: {type: String, minlength: [4, "Title must be at least 4 characters"]},
  price: {type: Number, min: [1, "Please enter product price"], max: [50000, "Please contact customer service if the price is over 50000"]},
  img: {type: String, required: [true, "Please enter image url"]}
}, { timestamps: true})

mongoose.model("Product", ProductSchema);

const Product = mongoose.model("Product");

module.exports = Product;