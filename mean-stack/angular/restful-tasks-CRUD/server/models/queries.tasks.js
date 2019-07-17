const Task = require("./Task");

module.exports = {
  getAllTasks(callback) {
    Task.find({}).then(tasks => {
      callback(null, tasks)
    })
    .catch(err => {
      callback(null);
    })
  },

  createTask(postData, callback) {
    let newTask = new Task(postData);
    newTask.save().then(task => {
      callback(null, task);
    })
    .catch(err => callback(err));
  },

  removeTask(id, callback) {
    Task.findById(id).then(task => {
      task.remove().then(() => {
        callback(null, task);
      })
      .catch(err => callback(err));
    })
    .catch(err => callback(err));
  },

  getTask(id, callback) {
    Task.findById(id).then(task => {
      console.log(id)
      callback(null, task);
    })
    .catch(err => callback(err));
  },

  updateTask(id, postData, callback) {
    Task.findByIdAndUpdate(id, {$set: postData}).then(task => {
      callback(null, task);
    })
    .catch(err => callback(err));
  }
}
