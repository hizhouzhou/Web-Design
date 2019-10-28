'use strict';
const mongoose = require('mongoose');
let Schema = mongoose.Schema;

let ContactSchema = new Schema({
    // first name
    first:{
        type:String,
        required: "first name is required"
    },

     // last name
     last:{
        type:String,
        required: "last name is required"
    },

     // email
     email:{
        type:String,
    },

    //phone
    phone:{
        type:String,
        required: "telephone number is required"
    }
}, {
    versionKey: false
});

ContactSchema.virtual('id').get(function(){
    return this._id.toHexString();
});
ContactSchema.set('toJSON', {
    virtuals: true
});

module.exports=mongoose.model('contacts',ContactSchema);
