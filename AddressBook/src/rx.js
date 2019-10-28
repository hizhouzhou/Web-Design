 import * as rxjs from 'rxjs';
import { ALPN_ENABLED } from 'constants';
 rxjs.of(1, 2, 3);

window.onload=()=>{
//button
let add=document.getElementById('add');
let cancel=document.getElementById('cancel');
let save=document.getElementById('save');
let creatediv=document.getElementById('dynamic-box');
//let view=document.getElementsByClassName('viewbtn');
let viewdiv=document.getElementById('viewpage');


//formFields


//address book display
let addBookDiv=document.getElementById('record-box');
const mainpageEvent$=rxjs.fromEvent(addBookDiv,'click');
let mainsubscription=mainpageEvent$.subscribe(getView);


//add event
const addevent$=rxjs.fromEvent(add,'click');

let addsubscription=  addevent$.subscribe(()=>{ 
    cancelsubscription.unsubscribe;
    creatediv.style.display='block';
    cancel.style.display='block';
    addBookDiv.style.display='none';
});
//cancel event
const cancelevent$=rxjs.fromEvent(cancel,'click');
let cancelsubscription=cancelevent$.subscribe(()=>{
    addsubscription.unsubscribe;
    creatediv.style.display='none';
    cancel.style.display='none';
    addBookDiv.style.display='block';
});

//view event
//getView = (e) =>{}
function getView(e){
    
    if(e.target.classList.contains('viewbtn')){
         let id=e.target.getAttribute('data-id');
        let view=document.getElementsByClassName('viewbtn')[id];
         //const phone=document.getElementsByClassName('phone')[id].innerText;
        const viewevent$=rxjs.fromEvent(view,'click');
        let viewsubscription=viewevent$.subscribe(viewDetail);
    }
        function viewDetail(){
            let phone=document.getElementsByClassName('phone')[id].innerText;
            //console.log(phone);
               fetch("http://localhost:3000/contacts/"+phone,{
                method: "GET",
                headers: {
                    'Content-Type':'application/json'
                }
                
            })
            .then(response =>response .json())
            .then(result =>{
                
                     console.log(result);
                     viewdiv.innerHTML='';
                for(let i in result){      
                   let str='<p>First Name: '+result[i].first +'</p>';
                   str+='<p>Last Name: '+result[i].last +'</p>';
                   str+='<p>Email: '+result[i].email +'</p>';
                   str+='<p>Phone: '+result[i].phone +'</p>';
                    viewdiv.innerHTML+=str;

            }
        });
           
        };
}



//save event
const saveevent$=rxjs.fromEvent(save,'click');
let savesubsription=saveevent$.subscribe(addToContact);


function addToContact(){
        console.log("Before POST");
       // viewsubscription.unsubscribe;
        addsubscription.unsubscribe;
        let first=document.getElementById("first").value;
        let last=document.getElementById("last").value;
        let email=document.getElementById("email").value;
        let phone=document.getElementById("phone").value;
        let valid =first!='' && last!='' &&phone!=''&&email!='';
        if(valid){
            //can add to the contact book     
            addBookDiv.style.display='block';    
            console.log("From POST Method");
            // fetch api
          fetch("http://localhost:3000/contacts",{
                method: "POST",
                headers:{
                    'Content-Type':'application/json'
                },
                body: JSON.stringify({
                    first:first,
                    last:last,
                    email:email,
                    phone:phone,
                })
            })
            .then(function(response){
                 response.json();
            });

            //Hide the form
            creatediv.style.display='none';
            cancel.style.display='none';
            //clear the form
            clearForm();
            showAddressBook();

        }else{
            console.log("please input");
        }
};

    function clearForm(){
       // let ff=document.querySelectorAll('.formFields');
       let ff=document.getElementsByClassName('formFields');
        for(let i in ff){
            ff[i].value='';
        }
    };

    // main page ,get data from mongodb
    function showAddressBook(){
      
        fetch("http://localhost:3000/contacts",{
            method: "GET",
            headers: {
                'Content-Type':'application/json'
            },
        })

        .then(response =>response.json())
        .then(result =>{
       
      
            //console.log(result);  
             addBookDiv.innerHTML = '';
             let count=0;
             for(let i in result){      
               //  console.log(count);     
                let str =' <div class="entry">';
                str+='   <div class="first"><p>'+result[i].first+'</p></div>';
                str+='  <div class="last"><p></p></div>';
                // str+='  <div class="email"><p></p></div>';
                str+=' <div class="phone"><p>'+result[i].phone+'</p></div>';
                str+='<div class="view"><p><button class="viewbtn" data-id="'+count+'">View</button><p></div>';
                str+=' </div>';
                addBookDiv.innerHTML +=str; 
                count++;  
        }
        });


    }


    //always show the address book in the main page
    showAddressBook();
}





