$(function () {
    let token = $("meta[name='_csrf']").attr("content"),
        header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

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

function checkReservation(reservationNumber) {
    return $.post('/booking/check', { reservationNumber: reservationNumber });
}

function getSpinner() {
    return $('<span />', {'class': 'sr-only'}).append($('<div />', {'class': 'spinner-border', 'role': 'status'}).text('Loading...'));
}