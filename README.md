# WhereAmI

This spigot plugin will add a command to show a link to the player's location in the web map.

## Commands and permissions

| Command            | Description     | Permission        | Default Permission |
|--------------------|-----------------|-------------------|--------------------|
| `/whereami reload` | Reloads config. | `whereami.reload` | op                 |
| `/map`             | Shows a link.   | `whereami.map`    | true               |           

## Config (config.yml)

```yaml
# Write your web map domain. It must start with "http" or "https", and end with slash.
# e.g.
# map-domain: "http://map.my-domain.com/"
map-domain: ""
```

## For contributors

* Use Conventional Commits in commit messages.
* Run `sbt assembly` to build a jar.
* Run `sbt scalafixAll` and `sbt scalafmtAll` to format codes.
 
## License

[MIT License](./LICENSE)
