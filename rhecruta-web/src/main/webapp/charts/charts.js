/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    
    function chart1() {
        var options = {
            chart: {
                renderTo: 'container',
                type: 'spline'
            },

            title: {
                text: 'Number of offers created per day'
            },

            subtitle: {
                text: 'Month result'
            },

            xAxix: {
                tickInterval: 1.0,
                allowDecimals: false,
                
            },

            yAxis: {
                tickInterval: 1.0,
                title: {
                    text: 'Number of Offers'
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle'
            },

            plotOptions: {
                series: {
                    pointStart: 1
                }
            },
            series: [{}]
        };
        var chart = new Highcharts.Chart(options);
        $.getJSON('/rhecruta-web/report/offer/daily', function (data) {
            options.series[0] = data;
            console.log(data);
            var chart = new Highcharts.Chart(options);
        });
    }
    
    function chart2() {
         var options = {
            chart: {
                renderTo: 'container2',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },

            title: {
                text: 'Requeried skills on offers'
            },

            tooltip: {
                pointFormat: '<b>{point.percentage:.1f}%</b>'
            },

            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        }
                    }
                }
            },
            series: [{}]
        };
        
        var chart2 = new Highcharts.Chart(options);
        $.getJSON('/rhecruta-web/report/skill', function (data) {
            options.series[0] = data;
            console.log(data);
            var chart2 = new Highcharts.Chart(options);
        });
        
    }
    
    function chart3() {
         var options = {
            chart: {
                renderTo: 'container3',
                type: 'column'
            },

            title: {
                text: 'Vacancies by Skill'
            },

            xAxis: {
                type: 'category',
                labels: {
//                    rotation: -45,
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Number of vacancies'
                }
            },
            
            legend: {
                enabled: false
            },

            tooltip: {
                pointFormat: 'Vacancies with this required skill: <b>{point.y} </b>'
            },
            series: [{
                    
            }]
        };
        
        var chart2 = new Highcharts.Chart(options);
        $.getJSON('/rhecruta-web/report/skill/vacancy', function (data) {
            options.series[0] = data;
            console.log(data);
            var chart2 = new Highcharts.Chart(options);
        });
        
    }

    chart1();
    chart2();
    chart3();
    

});


