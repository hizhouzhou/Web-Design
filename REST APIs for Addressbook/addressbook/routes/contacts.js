var express = require('express');
var router = express.Router();
var mongoose=require('mongoose');




const contactController = require('../controllers/contact-controller');

    router.get('/',contactController.list);
    router.get('/:phone',contactController.get);
    router.post('/',contactController.post);
   

    module.exports = router;












    
//  const Contact =require("../models/contact-pojo");
// router.get("/",(req,res,next) =>{
  
//     Contact.find(function(err,result){
//         res.json(result);
//     })

// });

// router.get("/:phone",(req,res,next) =>{
  
//     var phone=req.params.phone;

//     Contact.find({phone:phone},function(err,result){
//         res.json(result);
//     });
   
// });





// router.post("/",(req,res,next) =>{
//     const newContact =new Contact({
//         first:req.body.first,
//         last:req.body.last,
//         email:req.body.email,
//         phone:req.body.phone
//     });
//     newContact
//     .save()
//     .then((result) => {

//         console.log(result)
//     }).catch((err) => {
//         console.log(err);
//     });
//     res.status(201).json({
//         message: 'Handling POST requests to /User',
//         newContact: newContact
//     });
// });


