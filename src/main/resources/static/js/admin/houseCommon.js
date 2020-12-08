

var tipStr = '<option value="">请选择</option>';

function showError(message) {
    layer.msg("Error: " + message, {icon: 5, time: 2000});
}

function changeCity(city) {
    $.get('/address/supportCities', function (data, status) {
        if (status !== 'success' || data.code !== 200) {
            showError(data.message);
            return;
        }
        city.html(tipStr);
        var str = '';
        $.each(data.data, function (i, item) {
            str += "<option value=" + item.enName + ">" + item.cnName + "</option>";
        });
        city.append(str);
    });
}

function changeRegion(region, cityName) {
    $.get('/address/supportRegions?city_name=' + cityName, function (data, status) {
        if (status !== 'success' || data.code !== 200) {
            showError(data.message);
            return;
        }
        var selectedVal = region.val();
        region.html(tipStr);

        var str = "";
        $.each(data.data, function (i, item) {
            if (item.enName === selectedVal) {
                str += "<option value=" + item.enName + " selected='selected'>" + item.cnName + "</option>";
            } else {
                str += "<option value=" + item.enName + ">" + item.cnName + "</option>";
            }
        });
        region.append(str);
    });
}

function changeSubwayLine(subwayLine, cityName) {
    $.get('/address/supportSubway/line?city_name=' + cityName, function (data, status) {
        if (status !== 'success' || data.code !== 200) {
            showError(data.message);
            return;
        }
        subwayLine.html(tipStr);
        var str = "";
        $.each(data.data, function (index, subway) {
            str += "<option value=" + subway.subwayId + ">" + subway.subwayName + "</option>";
        });
        subwayLine.append(str);
    })
}

function changeSubwayStation(subwayStation, subwayLineId) {
    $.get('/address/supportSubway/station?subway_id=' + subwayLineId, function (data, status) {
        if (status !== 'success' || data.code !== 200) {
            showError(data.message);
            return;
        }

        subwayStation.html(tipStr);
        var str = "";
        $.each(data.data, function (index, station) {
            str += "<option value=" + station.subwayStationId + ">" + station.subwayStationName + "</option>";
        });
        subwayStation.append(str);
    })
}