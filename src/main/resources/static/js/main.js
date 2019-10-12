function getFormattedDate(date) {
    var year = date.getFullYear(),
        month = date.getMonth() + 1,
        date = date.getDate();
        if(month < 10) {
            month = "0" + month;
        }
        if(date < 10) {
            date = "0" + date;
        }
    return year + '-' + month + '-' + date;
}

function createBookedDatesArray(dates){
    var str = dates.substr(1, dates.lenght);
    str = str.substr(0, str.length - 1);
    str = str.replace(/\s/g, '');
    return str.split(',');
}