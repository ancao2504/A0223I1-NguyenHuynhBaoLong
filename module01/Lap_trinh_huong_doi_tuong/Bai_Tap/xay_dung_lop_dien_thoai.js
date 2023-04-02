class Mobile {
    constructor(pin, typingMessage, boxMessage, sentMessage, status, telephoneMember) {
        this.pin=pin;
        this.typingMessage=typingMessage;
        this.boxMessage=boxMessage;
        this.sentMessage=sentMessage;
        this.status=status;
        this.telephoneMember=telephoneMember;

        this.isStatus = function () {
            if (this.status == true) {
                return true;
            } else {
                return false;
            }
        };
        this.changeStatus = function () {
            this.status= !this.status;
            this.pin--;
        };
        this.chargePin = function () {
            while(this.pin < 100) {
                this.pin++;
            }
        };
        this.writingMessage = function (mobile) {
            if (this.status) {
                let mess=prompt("Write something!");
                let isSent=confirm("Do you want to send ?");
                if (isSent == true ) {
                    this.sentMessage.push(mobile.telephoneMember+" : "+mess);
                    mobile.boxMessage.push(this.telephoneMember+" : "+mess);
                    this.pin--;
                } else {
                    this.typingMessage.push(mess);
                    console.log(this.typingMessage);
                }
            } else {
                alert("Your phone is off !!!");
            }
        };
        this.seeBoxMessage = function () {
            if (this.status) {
                let temp="";
                for (let i = 0;i<this.boxMessage.length;i++) {
                    temp+= i + " : " + this.boxMessage[i]+'\n';
                }
                let index = confirm(temp);
                console.log(temp);
                alert(this.boxMessage[index]);
            } else {
                alert("Your phone is off !!!");
            }
            this.pin--;
        };
        this.seeSentMessage = function () {
            if (this.status) {
                let temp="";
                for (let i = 0;i < this.sentMessage.length;i++) {
                    temp+= i + ": " +this.sentMessage[i]+'\n';
                }
                let index = confirm(temp);
                alert(this.sentMessage[index]);
            } else {
                alert("Your phone is off !!!");
            }
            this.pin--;
        };
    }
}
let nokia = new Mobile(100, [], [], [], false, 0839000291);
let iphone = new Mobile(100, [], [], [], false, 096468582);
nokia.changeStatus();
iphone.changeStatus();
nokia.writingMessage(iphone);
iphone.seeBoxMessage();
nokia.seeSentMessage();


console.log("=======iphone=======",iphone);
console.log("=========nokia========",nokia);

