const Cake = require("./Cake");

module.exports = {
  getAllCakes(callback) {
    Cake.find({}).then(cakes => {
      callback(null, cakes)
    })
    .catch(err => {
      callback(null);
    })
  },

  createCake(postData, callback) {
    let newCake = new Cake(postData);
    newCake.save().then(cake => {
      callback(null, cake);
    })
    .catch(err => callback(err));
  },

  getCake(id, callback) {
    Cake.findById(id).then(cake => {
      Cake.aggregate().addFields({ // Add Average Field For Rating
        "rateAvg": {"$avg": "$rate"}
      }).then((newCake) => {
        console.log(newCake)
        callback(null, newCake);
      })
    })
    .catch(err => callback(err));
  },

  updateCake(id, postData, callback) {
    Cake.findByIdAndUpdate(id, {$push: postData}).then(cake => {
      callback(null, cake);
    })
    .catch(err => callback(err));
  }
}
