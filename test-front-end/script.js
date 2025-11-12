const chartData1 = {
    labels: ["Presença", "Falta", "Falta Justificada"],
    data: [60, 40, 10],
};

const meuChart1 = document.querySelector(".meu-chart1");

new Chart(meuChart1, {
    type: "bar",
    data: {
        labels: chartData1.labels,
        datasets: [
            { 
                label: "Presença", 
                minBarLength: 20,
                data: chartData1.data,
            },
        ],
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});





const chartData2 = {
    labels: ["Concluído", "Não concluído"],
    data: [50, 50],
};

const meuChart2 = document.querySelector(".meu-chart2");

new Chart(meuChart2, {
    type: "doughnut",
    data: {
        labels: chartData2.labels,
        datasets: [
            { 
                label: "Conclusão", 
                data: chartData2.data,
            },
        ],
    },
});

