'use strict'
const mongoose = require('mongoose');


// const Contact = mongoose.model('contacts');

const Contact =require("../models/contact-pojo");


/**
 * Throws error if error object is present.
 *
 * @param {Object} error {Error object}
 */
let throwError = function (error) {
    if (error) {
        throw Error(error);
    }
};

// /**
//  * Saves and returns the new contact object.
//  *
//  * @param {Object} contact {Contact object}
//  * @param {function} callback {Sucess callback function}
//  */
exports.save = function (contact) {
    const newContact = new Contact(contact);
    const promise = newContact.save();
    return promise;
};

// /**
//  * Returns the contact object.
//  *
//  * @param {string} phone {phone of the contact object}
//  * @param {function} callback {Sucess callback function}
//  */
exports.list = function (result) {
    const promise = Contact.find(result).exec();
    return promise
};
/**
 * Returns the contact object matching the phone.
 *
 * @param {string} id {id of the contact object}
 */
exports.get = function (phone) {
    const promise = Contact.find({phone: phone}).exec();
    return promise
};