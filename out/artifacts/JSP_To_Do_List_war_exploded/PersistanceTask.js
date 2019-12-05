function sendComplete(taskName) {
    // var form = document.getElementById("sendCompleteForm");
    // var hiddenInput = document.createElement("input");
    // hiddenInput.type = "hidden";
    // hiddenInput.name = "action";
    // hiddenInput.value = actionName;
    // form.appendChild(hiddenInput);
    // form.submit();

    var request = new XMLHttpRequest();

    request.open("PUT", "add-new?actionName=" + taskName, true);
    request.send();
}