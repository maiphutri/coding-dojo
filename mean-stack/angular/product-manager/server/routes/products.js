const express          = require("express"),
      router           = express.Router(),
      productController   = require("../controllers/productController");

router.get("/api/products", productController.products);
router.get("/api/products/:id", productController.show);
router.post("/api/products", productController.create);
router.put("/api/products/:id", productController.update);
router.delete("/api/products/:id", productController.destroy);

module.exports = router;