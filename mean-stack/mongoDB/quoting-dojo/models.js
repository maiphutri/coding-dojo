const mongoose = require("mongoose");

mongoose.Promise = require("bluebird");
mongoose.connect("mongodb://localhost/quoting_dojo")

const QuoteSchema =  new mongoose.Schema({
  name: String,
  quote: String,
  created_at: {type: Date, default: Date.now}
})
mongoose.model("Quote", QuoteSchema);
const Quote = mongoose.model("Quote");

module.exports = Quote;