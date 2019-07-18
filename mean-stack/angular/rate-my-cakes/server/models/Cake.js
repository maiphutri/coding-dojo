const mongoose    = require("mongoose"),
      shortid     = require("shortid");
      
mongoose.Promise = require("bluebird");
mongoose.connect("mongodb://localhost/rate-my-cake", {useNewUrlParser: true})


const CakeSchema = new mongoose.Schema({
  _id: {
    type: String,
    default: shortid.generate
  },
  baker: {type: String, minlength: [2, "Baker name must be at least 2 characters"]},
  img: {type: String, require: [true, "Please insert image url"]},
  comment: [String],
  rate: {type: [Number], min:1, max: 5}
}, { timestamps: true})

mongoose.model("Cake", CakeSchema);

const Cake = mongoose.model("Cake");
module.exports = Cake;