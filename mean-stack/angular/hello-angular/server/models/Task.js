  const mongoose    = require("mongoose");
      
mongoose.Promise = require("bluebird");
mongoose.connect("mongodb://localhost/tasks", {useNewUrlParser: true})


const TaskSchema = new mongoose.Schema({
  title: String,
  description: {type: String, default: ""},
  completed: {type: Boolean, default: false},
}, { timestamps: true})

mongoose.model("Task", TaskSchema);

const Task = mongoose.model("Task");

module.exports = Task;