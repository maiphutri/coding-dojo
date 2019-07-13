const mongoose = require("mongoose");

mongoose.Promise = require("bluebird");
mongoose.connect("mongodb://localhost/message_board")

const CommentSchema = new mongoose.Schema({
  name: {type: String, required: [true, "Please enter your name"], minlength: [2, "Name must be at least 2 characters"]},
  comment: {type: String, required: [true, "Comment cannot be blank"], minlength: [2, "Comment must be at least 2 characters"]},
}, { timestamps: true})

const MessageSchema =  new mongoose.Schema({
  name: {type: String, required: [true, "Please enter your name"], minlength: [2, "Name must be at least 2 characters"]},
  msg: {type: String, required: [true, "Message cannot be blank"], minlength: [10, "Message must be at least 10 characters"]},
  comments: [CommentSchema]
}, { timestamps: true })

mongoose.model("Comment", CommentSchema);
mongoose.model("Message", MessageSchema);

const Comment = mongoose.model("Comment");
const Message = mongoose.model("Message");

module.exports = {
  Comment: Comment,
  Message: Message
}