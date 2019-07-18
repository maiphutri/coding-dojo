const mongoose    = require("mongoose"),
      shortid     = require("shortid");
      
mongoose.Promise = require("bluebird");
mongoose.connect("mongodb://localhost/tasks", {useNewUrlParser: true})


const TaskSchema = new mongoose.Schema({
  _id: {
    type: String,
    default: shortid.generate
  },
  title: {type: String, minlength: [2, "Title must be at least 2 characters"]},
  description: {type: String, minlength: [10, "Description must be at least 10 characters"]},
  completed: {type: Boolean, default: false},
}, { timestamps: true})

mongoose.model("Task", TaskSchema);

const Task = mongoose.model("Task");

module.exports = Task;