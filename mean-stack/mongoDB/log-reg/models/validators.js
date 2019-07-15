const User = require("./User");

module.exports = {
  userValidator(postData) {
    let errors = {};
    let emailRegEx = /^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$/

    if (!emailRegEx.test(postData.email)) {
      errors.email = "Invalid email";
    }
    if (postData.firstName.length < 2) {
      errors.firstName = "Fist Name must be at least 2 characters"
    }
    if (postData.lastName.length < 2) {
      errors.lastName = "Last Name must be at least 2 characters"
    }
    if (postData.password.length < 8) {
      errors.password = "Password must be at least 8 characters";
    }
    if (postData.password !== postData.confirmPw) {
      errors.confirmPw = "Confirm password does not match the password above";
    }
    return errors;
  }
}
