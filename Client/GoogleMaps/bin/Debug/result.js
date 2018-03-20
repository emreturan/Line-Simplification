<!DOCTYPE html>
<html>
  <head>
    <title>Drawing tools</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
	<meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta charset="utf-8">
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #resultMap {
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
    <div id="resultMap"></div>
    <script>

      function initMap() {
        var resultMap = new google.maps.Map(document.getElementById('resultMap'), {
//Center Location
center: { lat: 61.2169633, lng: -149.8758583},
//Zoom
zoom: 16
        });
		
		var pathCoordinates = [
//Lat-Long data start
          {lat: 61.2169633, lng: -149.8758583},
          {lat: 61.2167133, lng: -149.8760516},
          {lat: 61.2166816, lng: -149.8761333},
          {lat: 61.2166949, lng: -149.87609},
          {lat: 61.2166666, lng: -149.8760733},
          {lat: 61.2168249, lng: -149.8762166},
          {lat: 61.2168666, lng: -149.8761266},
          {lat: 61.2169416, lng: -149.8762166},
          {lat: 61.2170699, lng: -149.8760933},
          {lat: 61.2171233, lng: -149.8761566},
          {lat: 61.217295, lng: -149.8761849},
          {lat: 61.2175983, lng: -149.875835},
          {lat: 61.2175733, lng: -149.8758599},
          {lat: 61.2175466, lng: -149.8757966},
          {lat: 61.2174683, lng: -149.8758199},
          {lat: 61.2169983, lng: -149.8763683},
          {lat: 61.2169983, lng: -149.87626},
          {lat: 61.2171016, lng: -149.8761016},
          {lat: 61.2172466, lng: -149.8760166},
          {lat: 61.2174449, lng: -149.87613},
          {lat: 61.2174433, lng: -149.87595},
          {lat: 61.2174383, lng: -149.876005},
          {lat: 61.2173916, lng: -149.8759599},
//Lat-Long data end
        ];
		
		var path = new google.maps.Polyline({
          path: pathCoordinates,
          strokeColor: '#ff0000',
          strokeOpacity: 1.0,
          strokeWeight: 2.5
        });
		
		path.setMap(resultMap);

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
		
        drawingManager.setMap(resultMap);
		
		var circleCenters = [
//Circles start
          {lat: 49.8704899, lng: 8.6491633},
          {lat: 49.8708949, lng: 8.6482833},
          {lat: 49.8700266, lng: 8.6495949},
          {lat: 49.8702583, lng: 8.6527699},
          {lat: 49.8701583, lng: 8.6501266},
          {lat: 49.8719049, lng: 8.6506216},
          {lat: 49.8719933, lng: 8.6525216},
          {lat: 49.8711383, lng: 8.6497716},
          {lat: 49.8710966, lng: 8.6521716},
//Circles end
		]
		
		for (var coor in circleCenters) {
          var cityCircle = new google.maps.Circle({
            strokeColor: '#00ff00',
            strokeOpacity: 1,
            strokeWeight: 2.5,
            fillColor: '#00ff00',
            fillOpacity: 1,
            map: resultMap,
            center: circleCenters[coor],
            radius: 1
          });
        }

		
		google.maps.event.addListener(drawingManager, 'overlaycomplete', function(event) {
			var bounds = event.overlay.getBounds();
			var ne = bounds.getNorthEast();
			var sw = bounds.getSouthWest();
			
			window.external.querySimplifiedData(ne.lat(), ne.lng(), sw.lat(), sw.lng(), resultMap.getZoom());
		});
      }
	  
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCOUJBE5QqKRJ7VceR35xoJO_qgBUjIlIk&libraries=drawing&callback=initMap"
         async defer></script>
  </body>
</html>
