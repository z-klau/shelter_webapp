	function editDog(name, sex, race, weight, placeOfFind, dateOfFind, penId,
			dogId) {
		document.getElementById('greenContainer').style.display = 'block';

		document.getElementById('name').value = name;

		document.getElementById('race').value = race;

		document.getElementById('weight').value = weight;

		document.getElementById('placeOfFind').value = placeOfFind;

		document.getElementById('dateOfFind').value = dateOfFind;

		document.getElementById('penId').value = penId;

		document.getElementById('dogId').value = dogId;

		if (sex == 'M') {
			document.getElementById('sexM').checked = 'checked';
		} else {
			document.getElementById('sexŻ').checked = 'checked';
		}
	}
	
	function hideForm() {
		document.getElementById('greenContainer').style.display = 'none';

	}