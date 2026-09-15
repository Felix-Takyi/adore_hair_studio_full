# Adore Hair Studio

Adore Hair Studio is a full-stack hair studio and e-commerce website for displaying wigs and other products, services, testimonials, reviews, contact information, and managing content through an admin console.

## Technology and tools used

### Frontend
- **HTML5** — page structure and content.
- **CSS3** — responsive layout, black/gold visual design, cards, modals, forms, animations, and dark mode.
- **JavaScript (Vanilla JS)** — product loading, search, cart, product gallery, reviews, settings integration, admin interactions, image-upload interactions, and theme switching.
- **Google Fonts** — Playfair Display and Poppins typography.
- **Font Awesome** — interface icons.
- **Browser Local Storage** — remembers the selected light/dark theme and other client-side preferences.

### Backend
- **Java** — backend programming language.
- **Spring Boot** — REST API and server-side application framework.
- **Spring Data JPA / Hibernate** — database persistence and object-relational mapping.
- **PostgreSQL** — relational database used by the deployed application.
- **Neon** — cloud-hosted PostgreSQL database used to provide the production database for the application.
- **REST API** — connects the frontend and admin console to the Spring Boot backend.
- **JWT authentication** — protects admin API operations.

### Image storage and media
- **Cloudinary** — cloud image storage and delivery for product images uploaded through the admin console. The Spring Boot backend uses the Cloudinary Java SDK and returns secure image URLs to the frontend. Product images are uploaded to the `adore-hair-studio/wigs` Cloudinary folder.

### Development tools
- **Visual Studio Code** — code editing and project development.
- **Git** — source-code version control.
- **Git Bash** — running Git and project commands on Windows.
- **GitHub** — remote source-code repository and version history.
- **Uptimerobot** - keep the site awake every 5 minutes. https://dashboard.uptimerobot.com

### Deployment / hosting
- **Vercel** — hosts the public frontend website.
- **Render** — hosts the Spring Boot backend/API.
- **Neon** — provides the cloud PostgreSQL database used by the deployed backend.
- **Cloudinary** — stores and delivers product images independently of the application server.

### Optional uptime support
- **UptimeRobot** — can be used to send periodic requests to the Render API to reduce the visible cold-start delay while the backend is running on Render's Free service. This is an optional workaround and is not part of the core application stack.

## Main features

- Product catalogue with **Wigs** and **Other Products** groups.
- Product search.
- Product descriptions with **Read More** details.
- Multiple product images and product gallery.
- Cloudinary-powered product image uploads from the admin console.
- Featured / best-seller products.
- Shopping cart and checkout flow.
- Product reviews and ratings.
- Services section.
- Testimonials.
- Admin product management.
- Admin list/grid display.
- Product added date and time.
- Homepage hero settings.
- Contact and social-media settings controlled from the admin console.
- Responsive mobile navigation.
- Light/dark mode toggle on the public website.
- Light/dark mode toggle on the admin console.
- Theme preference is remembered with browser Local Storage.

## Dark mode

The current update adds an animated light/dark switch to:

1. The public Adore Hair Studio website.
2. The admin console.

The public website stores its theme using:

`adore_theme`

The admin console stores its theme using:

`adore_admin_theme`

The theme is applied before the page finishes loading so the selected mode can be restored after a refresh.

## Architecture

```text
                         Adore Hair Studio
                                │
              ┌─────────────────┴─────────────────┐
              │                                   │
       Public Website                        Admin Console
          Vercel                              Spring Boot
              │                                   │
              └───────────────┬───────────────────┘
                              │
                       REST API / JWT
                              │
                       Spring Boot API
                           Render
                         /         \\
                        /           \\
                 PostgreSQL       Cloudinary
                    Neon          Product Images
```

## Deployment structure

```text
Adore Hair Studio
│
├── frontend/
│   └── index.html                 → Vercel public website
│
└── backend/
    └── Spring Boot API            → Render backend
        └── static/
            └── admin.html         → Admin console

External services:
├── Neon                        → PostgreSQL database
└── Cloudinary                  → Product image storage and delivery
```

## Applying the latest dark-mode update

Replace these two files in the existing repository:

```text
frontend/index.html
backend/src/main/resources/static/admin.html
```

Also make sure the updated `README.md` is in the repository root.

Then from the repository root run:

```bash
git status
git add frontend/index.html backend/src/main/resources/static/admin.html README.md
git commit -m "Add dark mode and document project tools"
git push origin main
```

After Vercel deploys the frontend, do a hard refresh in the browser with **Ctrl + Shift + R**.

Because `admin.html` is part of the Spring Boot backend, Render must also redeploy the backend for the admin-console dark mode to appear.

## Project services

- **Public frontend:** Vercel
- **Backend API:** Render
- **Database:** Neon PostgreSQL
- **Product image storage:** Cloudinary
- **Source repository:** GitHub

## Notes

The project is designed as a practical academic/business project. The public site and admin console communicate through the Spring Boot REST API. Neon provides the persistent PostgreSQL database, while Cloudinary stores and delivers product images uploaded through the admin console. JWT authentication protects administrative operations.
