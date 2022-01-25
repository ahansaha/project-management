const labels = [
	'January',
	'February',
	'March'
];

const data = {
	labels: labels,
	datasets: [{
		  label: 'My First dataset',
		  backgroundColor: ['#3e95cd', '#8e5ea2', '#3cba9f'],
		  borderColor: 'rgb(255, 99, 132)',
		  data: [5, 5, 5],
	}]
};

const config = {
	type: 'pie',
	data: data,
	options: {}
};

const myChart = new Chart(
	document.getElementById('myPieChart'),
	config
);