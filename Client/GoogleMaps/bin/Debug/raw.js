<html>
  <head>
    <title>Drawing tools</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
	<meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta charset="utf-8">
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>
    <script>

      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
//Center Location
center: { lat: 61.2169633, lng: -149.8758583},
//Zoom
zoom: 18
        });
		
		var pathCoordinates = [
//Lat-Long data start
          {lat: 61.2169633, lng: -149.8758583},
          {lat: 61.2169633, lng: -149.8758566},
          {lat: 61.2167133, lng: -149.8760516},
          {lat: 61.2167066, lng: -149.8760616},
          {lat: 61.21671, lng: -149.87606},
          {lat: 61.21671, lng: -149.87606},
          {lat: 61.2167133, lng: -149.8760516},
          {lat: 61.2166983, lng: -149.8760849},
          {lat: 61.21669, lng: -149.8761099},
          {lat: 61.2166816, lng: -149.8761333},
          {lat: 61.2166833, lng: -149.87612},
          {lat: 61.2166949, lng: -149.87609},
          {lat: 61.2166766, lng: -149.8760783},
          {lat: 61.2166666, lng: -149.876075},
          {lat: 61.2166666, lng: -149.8760766},
          {lat: 61.2166666, lng: -149.8760766},
          {lat: 61.2166666, lng: -149.8760766},
          {lat: 61.2166666, lng: -149.8760733},
          {lat: 61.2168249, lng: -149.8762166},
          {lat: 61.2168383, lng: -149.8761866},
          {lat: 61.2168533, lng: -149.8761466},
          {lat: 61.2168666, lng: -149.8761266},
          {lat: 61.2168766, lng: -149.8761266},
          {lat: 61.216885, lng: -149.8761366},
          {lat: 61.2168916, lng: -149.8761483},
          {lat: 61.2169, lng: -149.87616},
          {lat: 61.2169066, lng: -149.8761716},
          {lat: 61.2169166, lng: -149.8761799},
          {lat: 61.2169249, lng: -149.87619},
          {lat: 61.2169333, lng: -149.8762016},
          {lat: 61.2169416, lng: -149.8762166},
          {lat: 61.2169433, lng: -149.8762133},
          {lat: 61.2169433, lng: -149.8762133},
          {lat: 61.2169483, lng: -149.8762099},
          {lat: 61.2169866, lng: -149.8761966},
          {lat: 61.2170266, lng: -149.8761549},
          {lat: 61.2170699, lng: -149.8760933},
          {lat: 61.2170983, lng: -149.8761333},
          {lat: 61.2171133, lng: -149.8761466},
          {lat: 61.2171233, lng: -149.8761566},
          {lat: 61.2171633, lng: -149.8761683},
          {lat: 61.2172016, lng: -149.8761883},
          {lat: 61.2172416, lng: -149.8762033},
          {lat: 61.217295, lng: -149.8761849},
          {lat: 61.2173483, lng: -149.876145},
          {lat: 61.2174116, lng: -149.8760783},
          {lat: 61.2174899, lng: -149.8759666},
          {lat: 61.2175833, lng: -149.8758299},
          {lat: 61.2175983, lng: -149.875835},
          {lat: 61.2175733, lng: -149.8758599},
          {lat: 61.2175483, lng: -149.875825},
          {lat: 61.2175466, lng: -149.8757966},
          {lat: 61.2175216, lng: -149.8757933},
          {lat: 61.2174683, lng: -149.8758199},
          {lat: 61.2170199, lng: -149.8763433},
          {lat: 61.2170133, lng: -149.8763616},
          {lat: 61.2169983, lng: -149.8763683},
          {lat: 61.2169983, lng: -149.8763033},
          {lat: 61.2169983, lng: -149.87626},
          {lat: 61.2170066, lng: -149.87626},
          {lat: 61.2170133, lng: -149.8762516},
          {lat: 61.2170166, lng: -149.876245},
          {lat: 61.2170466, lng: -149.8761966},
          {lat: 61.2171016, lng: -149.8761016},
          {lat: 61.21713, lng: -149.8761016},
          {lat: 61.2171633, lng: -149.8760816},
          {lat: 61.2172216, lng: -149.8760416},
          {lat: 61.2172466, lng: -149.8760166},
          {lat: 61.2172799, lng: -149.8760182},
          {lat: 61.2172983, lng: -149.8760249},
          {lat: 61.21731, lng: -149.8760333},
          {lat: 61.2173049, lng: -149.8760383},
          {lat: 61.2172966, lng: -149.8760399},
          {lat: 61.2173033, lng: -149.8760549},
          {lat: 61.2174449, lng: -149.87613},
          {lat: 61.217425, lng: -149.8761016},
          {lat: 61.2173916, lng: -149.87605},
          {lat: 61.2174433, lng: -149.87595},
          {lat: 61.2174433, lng: -149.8759699},
          {lat: 61.2174383, lng: -149.876005},
          {lat: 61.2174016, lng: -149.8760149},
          {lat: 61.2173916, lng: -149.8759599},
//Lat-Long data end
        ];
		
		var path = new google.maps.Polyline({
          path: pathCoordinates,
          strokeColor: '#0000ff',
          strokeOpacity: 1.0,
          strokeWeight: 2.5
        });
		
		path.setMap(map);

        var drawingManager = new google.maps.drawing.DrawingManager({
          drawingMode: google.maps.drawing.OverlayType.MARKER,
          drawingControl: true,
          drawingControlOptions: {
            position: google.maps.ControlPosition.TOP_CENTER,
            drawingModes: ['rectangle']
          },
          markerOptions: {icon: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png'},
		  rectangleOptions: {
			  strokeColor: '#00ff00'
		  }
        });
		
        drawingManager.setMap(map);
		
				var circleCenters = [
//Circles start
          {lat: 61.2173483, lng: -149.876145},
          {lat: 61.2174449, lng: -149.87613},
          {lat: 61.217425, lng: -149.8761016},
          {lat: 61.2174116, lng: -149.8760783},
          {lat: 61.2173916, lng: -149.87605},
          {lat: 61.2174016, lng: -149.8760149},
          {lat: 61.2173916, lng: -149.8759599},
          {lat: 61.2174899, lng: -149.8759666},
          {lat: 61.2174433, lng: -149.8759699},
          {lat: 61.2174383, lng: -149.876005},
          {lat: 61.2174433, lng: -149.87595},
          {lat: 61.2175733, lng: -149.8758599},
          {lat: 61.2175833, lng: -149.8758299},
          {lat: 61.2175983, lng: -149.875835},
          {lat: 61.2175483, lng: -149.875825},
          {lat: 61.2175466, lng: -149.8757966},
          {lat: 61.2174683, lng: -149.8758199},
          {lat: 61.2175216, lng: -149.8757933},
//Circles end
		]
		
		for (var coor in circleCenters) {
          var cityCircle = new google.maps.Circle({
            strokeColor: '#00ff00',
            strokeOpacity: 1,
            strokeWeight: 2.5,
            fillColor: '#00ff00',
            fillOpacity: 1,
            map: map,
            center: circleCenters[coor],
            radius: 1
          });
        }
		
		google.maps.event.addListener(drawingManager, 'overlaycomplete', function(event) {
			var bounds = event.overlay.getBounds();
			var ne = bounds.getNorthEast();
			var sw = bounds.getSouthWest();
			
			window.external.queryRawData(ne.lat(), ne.lng(), sw.lat(), sw.lng(), map.getZoom());
		});
      }
	  
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCOUJBE5QqKRJ7VceR35xoJO_qgBUjIlIk&libraries=drawing&callback=initMap"
         async defer></script>
  </body>
</html>
