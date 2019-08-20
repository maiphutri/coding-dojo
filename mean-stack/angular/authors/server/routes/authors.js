const express           = require("express"),
      router            = express.Router(),
      authorController  = require("../controllers/authorController");

router.get("/api/authors", authorController.index);
router.post("/api/authors", authorController.create);
router.put("/api/authors/:id", authorController.update);

module.exports = router;