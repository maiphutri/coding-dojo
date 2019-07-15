  const mongoose    = require("mongoose");
      
mongoose.Promise = require("bluebird");
mongoose.connect("mongodb://localhost/log-reg", {useNewUrlParser: true})


const UserSchema = new mongoose.Schema({
  firstName: {
    type: String, 
    required: [true, "Please type in your first name"]
  },
  lastName: {
    type: String, 
    required: [true, "Please type in your last name"]
  },
  email: {
    type: String, 
    required: [true, "Please type in your email"]
  },
  password: String,
}, { timestamps: true})

mongoose.model("User", UserSchema);

const User = mongoose.model("User");

module.exports = User;