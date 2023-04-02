class myDate {
    constructor(day, month, year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.getDay = function () {
            return this.day;
        };
        this.getMonth = function () {
            return this.month;
        };
        this.getYear = function () {
            return this.year;
        };
        this.setDay = function (day) {
            this.day = day;
        };
        this.setMonth = function (month) {
            this.month = month;
        };
        this.setYear = function (year) {
            this.year = year;
        };
        this.setDate = function (day, month, year) {
            this.setDay(day);
            this.setMonth(month);
            this.setYear(year);
        };
        this.toString = function () {
            let d = this.day < 10 ? "0" + this.day : this.day;
            let m = this.month < 10 ? "0" + this.month : this.month;
            return d + '/' + m + '/' + this.year;
        };
    }
}
     let date = new myDate(2,2,2007);
     let day=date.getDay();
     let month=date.getMonth();
     let year=date.getYear();
     console.log(day+"/"+month+"/"+year);
    console.log(typeof day+"/"+typeof month+"/"+typeof year);
    date.setDay(10);
    date.setMonth(10);
    date.setYear(2004);
    day=date.getDay();
    month=date.getMonth();
    year=date.getYear();
    date.setDate(10,10,2004)
    console.log(typeof date.toString());
  
