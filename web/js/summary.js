$(document).ready(function () {
    $("#selectPie").click(function (){
        $("#pie").css("display","block");
        $("#zhi").css("display","none");
        $("#china-map").css("display","none");
    });
});

$(document).ready(function () {
    $("#selectZhi").click(function (){
        $("#pie").css("display","none");
        $("#zhi").css("display","block");
        $("#china-map").css("display","none");
    });
});

$(document).ready(function () {
    $("#selectMap").click(function (){
        $("#pie").css("display","none");
        $("#zhi").css("display","none");
        $("#china-map").css("display","block");
    });
});

$(document).ready(function () {
    $.ajax({
        type: "get",
        url: "../GenderSummary.do",
        dataType: "json",
        success: function (response) {
            const pie = echarts.init(document.getElementById('pie'));

            const option = {
                title: {
                    text: '性别比例',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left'
                },
                series: [
                    {
                        name: 'Access From',
                        type: 'pie',
                        radius: '50%',
                        data: response,
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };

            pie.setOption(option);
        }
    });
});

$(document).ready(function () {
    $.ajax({
        type: "get",
        url: "../ProvinceSummary.do",
        dataType: "json",
        success: function (response) {
            const zhi = echarts.init(document.getElementById('zhi'));

            const provinceName = [];
            const provinceAmount = [];

            for (let i = 0; i < response.length; i++) {
                provinceName.push(response[i].name);
                provinceAmount.push(response[i].value);
            }

            const option = {
                xAxis: {
                    type: 'category',
                    data: provinceName
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        data: provinceAmount,
                        type: 'bar'
                    }
                ]
            };
            zhi.setOption(option);
        }
    });
});

$(document).ready(function () {
    $.ajax({
        type: "get",
        url: "../ProvinceSummary.do",
        dataType: "json",
        success: function (response) {
            var date = SwitchSimpleProvinceName(response);
            const CMap = echarts.init(document.getElementById('china-map'));
            const option = {
                title: {
                    text: '人数分布',
                    subtext: '学习用途(虚构)',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    orient: 'horizontal',
                    x: 'left',
                    data: ['人数']
                },

                visualMap: {
                    x: 'left',
                    y: 'center',
                    min: 0,
                    max: 12,
                    calculable: true,
                    text: ['高', '低'],
                    color: ['#005196', '#008dff', '#bebebe']
                },
                toolbox: {
                    show: true,
                    orient: 'vertical',
                    x: 'right',
                    y: 'center',
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                roamController: {
                    show: true,
                    x: 'right',
                    mapTypeControl: {
                        'china': true
                    }
                },
                series: [
                    {
                        name: '人数',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        itemStyle: {
                            normal: {
                                label: {
                                    show: true,
                                    textStyle: {
                                        color: "rgb(249,249,249)"
                                    }
                                }
                            },
                            emphasis: {
                                label: {show: true},
                            }
                        },
                        top: "3%",
                        data: date
                    }
                ]
            };
            CMap.setOption(option);
        }
    });
});


function SwitchSimpleProvinceName(old) {
    var n = old;
    for (let i = 0; i < old.length; i++) {
        switch (old[i].name) {
            case "北京市":
                n[i].name = "北京";
                break;
            case "天津市":
                n[i].name = "天津";
                break;
            case "河北省":
                n[i].name = "河北";
                break;
            case "山西省":
                n[i].name = "山西";
                break;
            case "内蒙古自治区":
                n[i].name = "内蒙古";
                break;
            case "辽宁省":
                n[i].name = "辽宁";
                break;
            case "吉林省":
                n[i].name = "吉林";
                break;
            case "黑龙江省":
                n[i].name = "黑龙江";
                break;
            case "上海市":
                n[i].name = "上海";
                break;
            case "江苏省":
                n[i].name = "江苏";
                break;
            case "浙江省":
                n[i].name = "浙江";
                break;
            case "安徽省":
                n[i].name = "安徽";
                break;
            case "福建省":
                n[i].name = "福建";
                break;
            case "江西省":
                n[i].name = "江西";
                break;
            case "山东省":
                n[i].name = "山东";
                break;
            case "河南省":
                n[i].name = "河南";
                break;
            case "湖北省":
                n[i].name = "湖北";
                break;
            case "湖南省":
                n[i].name = "湖南";
                break;
            case "广东省":
                n[i].name = "广东";
                break;
            case "广西壮族自治区":
                n[i].name = "广西";
                break;
            case "海南省":
                n[i].name = "海南";
                break;
            case "重庆市":
                n[i].name = "重庆";
                break;
            case "四川省":
                n[i].name = "四川";
                break;
            case "贵州省":
                n[i].name = "贵州";
                break;
            case "云南省":
                n[i].name = "云南";
                break;
            case "西藏自治区":
                n[i].name = "西藏";
                break;
            case "陕西省":
                n[i].name = "陕西";
                break;
            case "甘肃省":
                n[i].name = "甘肃";
                break;
            case "青海省":
                n[i].name = "青海";
                break;
            case "宁夏回族自治区":
                n[i].name = "宁夏";
                break;
            case "新疆维吾尔自治区":
                n[i].name = "新疆";
                break;
            case "台湾省":
                n[i].name = "台湾";
                break;
            case "香港特别行政区":
                n[i].name = "香港";
                break;
            case "澳门特别行政区":
                n[i].name = "澳门";
                break;
        }
    }
    return n;
}
