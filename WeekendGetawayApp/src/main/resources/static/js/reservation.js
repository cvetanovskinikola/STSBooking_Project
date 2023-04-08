let periodTracker;
let submit = document.getElementById('sub');

function setSingleFee(){
	let room = document.getElementsByName("onePersonRoom");
	submit.value="Reserve" + "( " + room.values +" EUR. )";
}

function setTwoFee(){
	let room = document.getElementsByName("twoPersonRoom");
	submit.value="Reserve" + "( " + room.values +" EUR. )";
}

function setTripleFee(){
	let room = document.getElementsByName("threePersonRoom");
	submit.value="Reserve" + "( " + room.values +" EUR. )";
}
function setFamilyFee(){
	let room = document.getElementsByName("familyRoom");
	submit.value="Reserve" + "( " + room.values +" EUR. )";
}
function setFee(){
	let roomfour = document.getElementsByName("familyRoom");
	let roomthree = document.getElementsByName("threePersonRoom");
	let roomtwo = document.getElementsByName("twoPersonRoom");
	let roomone = document.getElementsByName("onePersonRoom");
	submit.value="Reserve" + "( " + r
}
const setError = (element, message) => {
	
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.remove('success');
    inputControl.classList.add('error');
 }
 const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('error');
};
 function acceptedBoxVal(){
	
	let checkbox = document.getElementById('accept');
	if(!checkbox.checked){
		setError(checkbox, "Terms and conditions must be accepted!")
		return false;
	}
	setSuccess(checkbox);
	return true;
}