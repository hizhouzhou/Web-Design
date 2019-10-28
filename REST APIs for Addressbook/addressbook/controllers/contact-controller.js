// controller for contact endpoints.

'use strict'
//import contract service

const contactService = require('../services/contact-service');

/**
 * Returns a contact object in JSON.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.get = function (request, response) {
    const resolve = (contact) => {
        response.status(200);
        response.json(contact);
    };
    contactService.get(request.params.phone)
        .then(resolve)
       
};



exports.post = function(request, response){
    let newContact = Object.assign({},request.body),
    callback = function(contact){
        response.status(200);
        response.json(contact);
    };
    contactService.save(newContact, callback);
};



exports.list = function (request, response) {
    const resolve = (contact) => {
        response.status(200);
        response.json(contact);
    };
    contactService.list()
        .then(resolve)
       
};
