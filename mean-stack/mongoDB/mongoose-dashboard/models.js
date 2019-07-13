const mongoose = require("mongoose");

mongoose.Promise = require("bluebird");
mongoose.connect("mongodb://localhost/mongoose_dashboard")

const MongooseSchema =  new mongoose.Schema({
  name: String,
  img: String,
  characteristic: String,
  favFoods: {type: [String]},
},
{
  timestamps: true
}
)
mongoose.model("Mongoose", MongooseSchema);
const Mongoose = mongoose.model("Mongoose");

module.exports = Mongoose;