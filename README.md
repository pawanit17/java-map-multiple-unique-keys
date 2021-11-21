# java-map-multiple-unique-keys
This is an example of a scenario where a map is used with a key that is made up of multiple attributes. All Java Collections rely on hashCode and equals methods to look up where a certain object is held in the collection or to know where to map a certain object into the collection. So overriding one of them would also need to override the other one as well. This is covered in Effective Java by Joshua Bloch. A summary is also present in this stack overflow post https://stackoverflow.com/a/2265637/815961

