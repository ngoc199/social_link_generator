let buttons = document.querySelectorAll("button");

buttons.forEach((button) => {
	button.addEventListener("click", (e) => {
		// Get the data from the clicked button, then add its value to an input element
		let data = button.getAttribute("data-copy");
		let node = document.createElement("input");
		node.type = "text";
		node.value = data;

		// The element must be appeared in document to be selected
		document.body.appendChild(node);
		node.select();

		// Execute the copy command to copy the value to the clipboard
		document.execCommand("copy");

		// Remove the element from the document
		document.body.removeChild(node);
		node.remove();
	});
});
