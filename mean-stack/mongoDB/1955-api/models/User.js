  const mongoose    = require("mongoose");
      
mongoose.Promise = require("bluebird");
mongoose.connect("mongodb://localhost/1955-api", {useNewUrlParser: true})


const UserSchema = new mongoose.Schema({
  name: {
    type: String, 
    required: [true, "Please type in your first name"]
  },
}, { timestamps: true})

mongoose.model("User", UserSchema);

const User = mongoose.model("User");

module.exports = User;